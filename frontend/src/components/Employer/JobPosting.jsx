import React, { useEffect, useState } from "react";
import Category from "../Category";
import { MdEdit } from "react-icons/md";
import { MdDelete } from "react-icons/md";


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
      <div className="bg-white rounded-lg shadow-lg p-8 m-4 max-w-2xl w-full">
      <div className='flex justify-evenly'>
          <div className='flex justify-center'>
            <h1 className="text-md font-semibold mb-4">Job Posting</h1>
          </div>
          <div className='flex justify-end ml-20'>
            <MdEdit className="mr-3"/>
            <MdDelete />
          </div>
        </div>
        <h1 className="text-xs font-semibold mb-2">Position</h1>
        <input
          className="mb-2 w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
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
              className="w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
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
              className="w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
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
              className="w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
              type="email"
              placeholder="Email"
              readOnly={!isEditable}
              value={jobDetails.email}
              onChange={(e)=>handleChange("email",e.target.value)}
            />
          </div>
          <div className="w-1/2 ml-1">
            <div className="relative">
              <div className="absolute inset-y-0 left-0 flex items-center pointer-events-none">
                {/*} <FiMail className="text-gray-500" /> */}
              </div>
              <h1 className="text-xs font-semibold mb-2">Pay Per Hour</h1>
              <input
                className="w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
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
                  className="w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darke"
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
                  className="w-full px-4 py-2 text-xs border rounded shadow appearance-none text-grey-darke"
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
        <div className="flex items-center justify-between mt-4 mb-8">
          <div className="flex-1 ml-3">
            <button className=" mt-8 flex w-full justify-center rounded-md bg-fbblue px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">
              Save & Finish
            </button>
          </div>
        </div>
      </div>
    </div>
    
  );
};

export default JobPosting;
