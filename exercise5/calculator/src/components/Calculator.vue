<template>
  <div class="page">
    <div class="calculator">
      <div class="button display">{{ current }}</div>
      <div class="button operator2" @click="clear">C</div>
      <div class="button operator2" @click="negate">+/-</div>
      <div class="button operator2" @click="percent">%</div>
      <div class="button operator" @click="setOperator('/')">/</div>
      <div class="button" @click="update(7)">7</div>
      <div class="button" @click="update(8)">8</div>
      <div class="button" @click="update(9)">9</div>
      <div class="button operator" @click="setOperator('x')">x</div>
      <div class="button" @click="update(4)">4</div>
      <div class="button" @click="update(5)">5</div>
      <div class="button" @click="update(6)">6</div>
      <div class="button operator" @click="setOperator('-')">-</div>
      <div class="button" @click="update(1)">1</div>
      <div class="button" @click="update(2)">2</div>
      <div class="button" @click="update(3)">3</div>
      <div class="button operator" @click="setOperator('+')">+</div>
      <div class="button null" @click="update(0)">0</div>
      <div class="button" @click="setDot">.</div>
      <div class="button operator" @click="calculate">=</div>
    </div>
    <div class="log">
      <ul>
        <li v-for="calc in calculations" v-bind:key="calc.id">
          {{ calc.str }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      current: "",
      operator: "",
      isOperator: false,
      prevNum: null,
      calculations: [],
    };
  },
  methods: {
    update(num) {
      if (this.current.charAt(0) !== "0") {
        this.current = `${this.current}${num}`;
      }
    },
    clear() {
      this.current = "";
    },
    del() {
      this.current = this.current.slice(0, this.current.length - 1);
    },
    setOperator(operator) {
      this.removeDot();
      if (!this.isOperator) {
        this.operator = operator;
        this.isOperator = true;
        this.prevNum = this.current;
      }
      this.current = "";
    },
    calculate() {
      if (this.prevNum !== null && this.isOperator) {
        this.removeDot();
        let secNum = this.current;
        const calculate = this.prevNum + this.operator + this.current;
        const execute = async () => {
          const request = await fetch("/calculate", {
            method: "POST",
            headers: {
              Accept: "application/json",
              "Content-Type": "application/json",
            },
            body: JSON.stringify({ calculate: calculate }),
          });
          return request.json();
        };
        execute();
        /*
        if (this.operator.charAt(0) === "+") {
          //this.current = `${parseFloat(this.prevNum) +
          //parseFloat(this.current)}`;
        } else if (this.operator.charAt(0) === "-") {
          this.current = `${parseFloat(this.prevNum) -
            parseFloat(this.current)}`;
        } else if (this.operator.charAt(0) === "x") {
          this.current = `${parseFloat(this.prevNum) *
            parseFloat(this.current)}`;
        } else if (this.operator.charAt(0) === "/") {
          this.current = `${parseFloat(this.prevNum) /
            parseFloat(this.current)}`;
        }
        */
        this.calculations.push({
          str:
            this.prevNum +
            " " +
            this.operator +
            " " +
            secNum +
            " = " +
            this.current,
          id: this.calculations.length,
        });
        this.isOperator = false;
      }
    },
    setDot() {
      if (this.current.indexOf(".") === -1) {
        this.current = this.current + ".";
      }
    },
    removeDot() {
      if (this.current.charAt(this.current.length - 1) === ".") {
        this.current = this.current.slice(0, this.current.length - 1);
      }
    },
    negate() {
      this.current =
        this.current.charAt(0) === "-"
          ? this.current.slice(1)
          : `-${this.current}`;
    },
    percent() {
      let percent = this.current;
      this.current = `${parseFloat(this.current) / 100}`;
      this.calculations.push({ str: percent + " % = " + this.current });
    },
  },
};
</script>

<style scoped>
.page {
  display: grid;
  grid-template-columns: 300px 300px;
  justify-content: center;
}
.calculator {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-auto-rows: minmax(50px, auto);
  width: 300px;
  margin: 0 auto;
  font-size: 20px;
  text-align: center;
  grid-column: 1 / 2;
}
.log {
  width: 400px;
  height: 300px;
  border: 1px solid black;
  margin-left: 30px;
  grid-column: 2 / 3;
  border-radius: 5px;
}
.button {
  border: 1px solid black;
  background-color: lightgrey;
  margin: 2px;
  border-radius: 5px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.display {
  grid-column: 1 /5;
  background-color: beige;
}
.operator {
  background-color: orange;
}
.operator2 {
  background-color: grey;
}
.null {
  grid-column: 1 / 3;
}

@media only screen and (max-width: 600px) {
  .calculator {
    font-size: 10px;
    width: 50vh;
    height: 70vh;
  }
  .log {
    width: 40vh;
    height: 70vh;
    font-size: 10px;
  }
}
</style>
