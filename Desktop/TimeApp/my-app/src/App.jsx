
import React from 'react';
import './App.css';

const oneSecond = () => 1000;
const getCurrentTime = () => new Date();

const serializeClockTime = (date) => ({
  hours: date.getHours(),
  minutes: date.getMinutes(),
  seconds: date.getSeconds(),
});

const civilianHours = (clockTime) => ({
  ...clockTime,
  hours: clockTime.hours > 12 ? clockTime.hours - 12 : clockTime.hours,
});

const appendAMPM = (clockTime) => ({
  ...clockTime,
  ampm: clockTime.hours >= 12 ? "PM" : "AM",
});

const display = (target) => (time) => target(time);

const formatClock = (format) => (time) =>
  format
    .replace("hh", time.hours)
    .replace("mm", time.minutes)
    .replace("ss", time.seconds)
    .replace("tt", time.ampm);

const prependZero = (key) => (clockTime) => ({
  ...clockTime,
  [key]: clockTime[key] < 10 ? "0" + clockTime[key] : clockTime[key],
});

const compose =
  (...fns) =>
  (arg) =>
    fns.reduce((composed, f) => f(composed), arg);

const convertToCivilianTime = (clockTime) =>
  compose(appendAMPM, civilianHours)(clockTime);

const doubleDigits = (civilianTime) =>
  compose(prependZero("hours"), prependZero("minutes"), prependZero("seconds"))(
    civilianTime
  );

const getClockTime = () =>
  compose(
    getCurrentTime,
    serializeClockTime,
    convertToCivilianTime,
    doubleDigits,
    formatClock("hh:mm:ss tt")
  )();

setInterval(() => {
  const clockElement = document.getElementById("clock");
  if (clockElement) {
    clockElement.innerText = getClockTime();
  }
}, oneSecond());

const Clock = () => {
  return (
    <div className="container">
      <h1>Current Time:</h1>
      <h2 id="clock" className="clock">{getClockTime()}</h2>
    </div>
  );
};

export default Clock;