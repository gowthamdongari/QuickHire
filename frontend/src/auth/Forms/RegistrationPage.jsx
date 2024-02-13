import React from "react";

const RegistrationPage = () => {
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
    Firstname: {
      color: "#3a3a3a",
      fontSize: "18px",
      fontFamily: "Source Sans Pro",
      fontWeight: 500,
      lineHeight: "31px",
    },
    InputField: {
      top: "426px",
      left: "143px",
      width: "468px",
      height: "48px",
      padding: "0px 8px",
      border: "0",
      boxSizing: "border-box",
      borderRadius: "24px",
      backgroundColor: "#f2f2f2",
      color: "#282828",
      fontSize: "14px",
      fontFamily: "Source Sans Pro",
      fontWeight: 500,
      lineHeight: "18px",
      outline: "none",
    },
    Button: {
      cursor: "pointer",
      top: "1192px",
      left: "491px",
      width: "468px",
      height: "48px",
      padding: "0px 8px",
      border: "0",
      boxSizing: "border-box",
      borderRadius: "24px",
      backgroundColor: "#e22823",
      color: "#ffffff",
      fontSize: "16px",
    },
  };
  return (
    <div>

      <h3 style={mystyle.Registration}>Employer Registration</h3>
      <p style={mystyle.Para}>Enter your company details to continue</p>
      <form className="flex flex-col justify-center ml-[220px]">
        {/* Personal Details */}
        <div className="grid grid-cols-2 gap-0">
          <div className="m-4">
            <label>FirstName:</label>
            <br></br>
            <input
              className="regInput"
              placeholder="enter your first name"
              type="text"
            />
          </div>
          <div className="m-4">
            <label>Last Name:</label>
            <br></br>
            <input
              className="regInput"
              placeholder="Enter your last name"
              type="text"
            />
          </div>
          <div className="m-4">
            <label>Company name:</label>
            <br></br>
            <input
              className="regInput"
              placeholder="Enter the company name"
              type="text"
            />
          </div>
          <div className="m-4">
            <label>Preferred Username:</label>
            <br></br>
            <input
              className="regInput"
              placeholder="Create your unique Username"
              type="text"
            />
          </div>
          <div className="m-4">
            <label>Email:</label>
            <br></br>
            <input
              className="regInput"
              placeholder="Enter your mail Address"
              type="email"
            />
          </div>
          <div className="m-4">
            <label>Phone No:</label>
            <br></br>
            <input
              className="regInput"
              placeholder="Enter your phone number"
              type="text"
            />
          </div>
          <div className="m-4">
            <label>Mailing Addres:</label><br></br>
            <input
              className="regInput"
              placeholder="Enter your mail Address"
              type="email"
            />
          </div>
          <div className="m-4">
            <label>City:</label><br></br>
            <input
              className="regInput"
              placeholder="Enter your mail Address"
              type="email"
            />
          </div>
          <div className="m-4">
            <label>State:</label><br></br>
            <input
              className="regInput"
              placeholder="Enter your mail Address"
              type="email"
            />
          </div>
          <div className="m-4">
            <label>Zipcode:</label><br></br>
            <input
              className="regInput"
              placeholder="Enter your mail Address"
              type="email"
            />
          </div>
        </div>
        <button type="submit" className="ml-[300px] w-[468px] h-[48px] p-2  rounded-3xl  bg-[#e22823] decoration-[#ffffff] cursor-pointer leading-5 font">Register</button>
      </form>
    </div>
  );
};

export default RegistrationPage;
