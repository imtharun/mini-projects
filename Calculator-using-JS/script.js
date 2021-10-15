"use strict";

const numberCnt = document.querySelectorAll(".card__c");
const ip = document.querySelector(".card__sol");
const ac = document.querySelector(".card__clr");
const signs = document.querySelectorAll(".card__c__sign");
const equal = document.querySelector(".card__c__equal");

let symbol = "";

ac.addEventListener("click", function () {
  ip.value = "";
});

for (let i = 0; i < numberCnt.length; i++) {
  numberCnt[i].addEventListener("click", function () {
    let val = numberCnt[i].textContent;
    ip.value += val;
  });
}

for (let i = 0; i < signs.length; i++) {
  signs[i].addEventListener("click", function () {
    let sign = signs[i].textContent;
    symbol = sign;
    console.log(sign);
    ip.value += ` ${sign} `;
  });
}

equal.addEventListener("click", function () {
  let final = ip.value;
  let index = final.indexOf(symbol);
  let num1 = Number(final.slice(0, index));
  let num2 = Number(final.slice(index + 1));
  if (symbol === "+") {
    ip.value = num1 + num2;
  } else if (symbol === "-") {
    ip.value = num1 - num2;
  } else if (symbol === "*") {
    ip.value = num1 * num2;
  } else if (symbol === "/") {
    ip.value = num1 / num2;
  }
});
