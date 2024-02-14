import React, { useState } from "react";
import Category from "../../components/Category";
import EducationList from "../../components/EducationList";
import { useNavigate } from "react-router-dom";

const Education = () => {
  const [educationDetails, setEducationDetails] = useState({
    schoolName: "",
    major: "",
    endTime: "",
  });
  const [totalEducationDetails, setTotalEducationDetails] = useState([]);
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
  const navigation = useNavigate();
  
  const handleChange = (key, val) => {
    setEducationDetails({ ...educationDetails, [key]: val });
  };
  const handleAdd = () => {
    console.log(educationDetails);
    if (totalEducationDetails) {
      setTotalEducationDetails([...totalEducationDetails, educationDetails]);
    } else {
      setTotalEducationDetails([educationDetails]);
    }
    console.log(totalEducationDetails);
    setEducationDetails({ schoolName: "", major: "", endTime: "" });
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
              <input
                value={educationDetails.schoolName}
                onChange={(e) => handleChange("schoolName", e.target.value)}
                placeholder="Enter your school name"
                type="text"
              />
            </div>
            <div>
              <label>Major:</label>
              <br></br>
              <input
                value={educationDetails.major}
                onChange={(e) => handleChange("major", e.target.value)}
                placeholder="Enter your major"
                type="text"
              />
            </div>
            <div>
              <label>Completion Time:</label>
              <br></br>
              <input
                value={educationDetails.endTime}
                onChange={(e) => handleChange("endTime", e.target.value)}
                type="date"
              />
            </div>
            <div className="mt-6">
              <button
                type="button"
                onClick={handleAdd}
                className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
              >
                add
              </button>
            </div>
          </div>
          {totalEducationDetails && (
            <div className="w-[800px] h-fit mt-6">
              <EducationList educationDetails={totalEducationDetails} />
            </div>
          )}
          <div className="mt-7">
            <button 
             onClick={()=>navigation("/category")}
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
              next
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Education;

//export default EducationForm;
