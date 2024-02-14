import React, { useEffect, useState } from "react";
import { FiMail, FiPlusCircle } from "react-icons/fi";
import Category from "../Category";

const JobPosting = ({isView=false}) => {
   const  [jobDetails,setJobDetails] = useState({position:"Software Developer",firstName:"John",lastName:"Doe",email:"john@gmail.com",pay:"35$",startDate:"2020-02-03",endDate:"2020-04-03"})
   const [isEditable,setIsEditable] = useState(!isView);
   console.log(isView)
   const handleChange =(key,val)=>{
      setJobDetails({...jobDetails,[key]:val})
   } 

   useEffect(()=>{
      if(!isView){
         setJobDetails({position:"",firstName:"",lastName:"",email:"",pay:"",startDate:"",endDate:""})
      }
   },[])
  return (
    <div className="bg-gray-50 min-h-screen flex justify-center w-full">
      <button onClick={()=>setIsEditable(true)}>Edit</button>
      <div className="bg-white rounded-lg shadow-lg p-8 m-2 max-w-2xl w-full">
        <h1 className="text-xs font-semibold mb-2">Position</h1>
        <input
          className="mb-2 w-full px-3 py-2 border rounded shadow appearance-none text-grey-darker"
          type="text"
          readOnly={!isEditable}
          value={jobDetails.position}
          onChange={(e)=>handleChange("position",e.target.value)}
          placeholder="Name of Position ex: Software Engineer"
        />

        <div className="flex flex-wrap -mx-2 mb-2">
          <div className="w-full md:w-1/2 px-2 mb-2 md:mb-0">
            <h1 className="text-xs font-semibold mb-2">First Name</h1>
            <input
              className="w-full px-3 py-2 border rounded shadow appearance-none text-grey-darker"
              type="text"
              placeholder="First Name"
              readOnly={!isEditable}
              value={jobDetails.firstName}
              onChange={(e)=>handleChange("firstName",e.target.value)}
            />
          </div>
          <div className="w-full md:w-1/2 px-2">
            <h1 className="text-xs font-semibold mb-2">Last Name</h1>
            <input
              className="w-full px-3 py-2 border rounded shadow appearance-none text-grey-darker"
              type="text"
              placeholder="Last Name"
              readOnly={!isEditable}
              value={jobDetails.lastName}
              onChange={(e)=>handleChange("lastName",e.target.value)}
            />
          </div>
        </div>
        <div className="flex mb-2">
          <div className="w-1/2 mr-1">
            <h1 className="text-xs font-semibold mb-2">Email</h1>
            <input
              className="w-full px-3 py-2 border rounded shadow appearance-none text-grey-darker"
              type="email"
              placeholder="Email"
              readOnly={!isEditable}
              value={jobDetails.email}
              onChange={(e)=>handleChange("email",e.target.value)}
            />
          </div>
          <div className="w-1/2 ml-1">
            <div className="relative">
              <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                {/* <FiMail className="text-gray-500" /> */}
              </div>
              <h1 className="text-xs font-semibold mb-2">Pay Per Hour</h1>
              <input
                className="w-full px-3 py-2 border rounded shadow appearance-none text-grey-darker pl-10"
                type="text"
                placeholder="Enter pay per hour in $"
                readOnly={!isEditable}
                value={jobDetails.pay}
                onChange={(e)=>handleChange("pay",e.target.value)}
              />
            </div>
          </div>
        </div>
        <div className="flex flex-wrap -mx-2 mb-2">
          <div className="w-full md:w-1/2 px-2 mb-2 md:mb-0">
            <div className="flex flex-row mt-4">
              <div className="flex justify-between ">
                <label
                  htmlFor="start-date"
                  className="text-xs font-semibold mb-2"
                >
                  Start Date:
                </label>
                <input
                  type="date"
                  id="start-date"
                  className="px-4 border rounded p-2 shadow appearance-none text-grey-darke"
                  readOnly={!isEditable}
                  value={jobDetails.startDate}
                  onChange={(e)=>handleChange("startDate",e.target.value)}
                />
              </div>
              <div className="flex justify-between">
                <label htmlFor="end-date" className="text-xs font-semibold m-2">
                  End Date:
                </label>
                <input
                  type="date"
                  id="end-date"
                  className="px-4border rounded p-2 shadow appearance-none text-grey-darke"
                  readOnly={!isEditable}
                  value={jobDetails.endDate}
                  onChange={(e)=>handleChange("endDate",e.target.value)}
                />
              </div>
            </div>
          </div>
        </div>
        <div className="flex items-start mt-6 text-base font-medium">
          <Category isCategory={isView} />
        </div>
        <div className="flex items-center justify-between mt-8 mb-8">
          <div className="flex-1 ml-3">
            <button className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded-full w-full">
              Save & Finish
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default JobPosting;
