import React, { useState } from "react";
import Category from "../../components/Category";

const Education = () => {
  const mystyle = {
    Header: {
      color: "#5856d6",
      fontsize: "48px",
      fontFamily: "Roboto Slab",
      fontWeight: "500",
      lineHeight: "62px",
      textAlign: "center",
    },
    Registration: {
      color: "#3a3a3a",
      fontSize: "40px",
      fontFamily: "Source Sans Pro",
      fontWeight: 700,
      lineHeight: "38px",
      textAlign: "center",
    },
    Para: {
      color: "#3a3a3a",
      fontSize: "18px",
      fontFamily: "Source Sans Pro",
      lineHeight: "31px",
      textAlign: "center",
    },
  };
  return (
    <div>
      <h1 style={mystyle.Header}>QuickHire</h1>
      <h3 style={mystyle.Registration}>Professional Registration</h3>
      <p style={mystyle.Para}>Enter your Education details to continue</p>
      <div>
        <form className="justify-center ml-[350px] mt-[60px]">
          <div className="flex flex-row gap-5">
            <div>
              <label>School Name:</label>
              <br></br>
              <input placeholder="Enter your school name" type="text" />
            </div>
            <div>
              <label>Major:</label>
              <br></br>
              <input placeholder="Enter your major" type="text" />
            </div>
            <div>
              <label>Completion Time:</label>
              <br></br>
              <input type="date" />
            </div>
            <div className="mt-6">
              <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                add
              </button>
            </div>
          </div>
          <div>{/* Need to write table here */}</div>
          <div className="mt-7">
            <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
              next
            </button>
          </div>
        </form>
      </div>
      <div className="w-[600px]">
        <Category />
      </div>
    </div>
  );
};

export default Education;

//export default EducationForm;
