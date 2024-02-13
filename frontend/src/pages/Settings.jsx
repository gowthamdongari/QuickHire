import React, { useState } from "react";
import {useNavigate} from 'react-router-dom'

const Settings = () => {
  const [isEditable, setIsEditable] = useState(false);
  const [userDetails,setUserDetails] = useState({email:"staff@quickhire.com" ,phone:"909999999"});
  const navigate = useNavigate();
  const handleEdit = (val) => {
    setIsEditable(val);
    console.log(isEditable);
    if(val==false){
      setUserDetails({email:"staff@quickhire.com" ,phone:"909999999"});
    }
  };
  const handleChange =(key,val)=>{
     setUserDetails({...userDetails,[key]:val});
  }

  const navigationButton =(val)=>{
      if(val=="add"){
        navigate("createAccount")
      }else{
        navigate("staffAccounts")
      }
  }

  return (
    <div className="flex justify-center container flex-col">
      <h3 className="text-4xl font-bold">Account Settings</h3> <br></br>
      <form className="flex flex-col">
        <div className="m-5">
          <label>Email:</label>
          <br></br>
          <input
            className="regInput"
            readOnly={!isEditable}
            value={userDetails.email}
            onChange={(e)=>handleChange("email",e.target.value)}
            type="text"
          />
        </div>
        <div className="m-5">
          <label>Phone:</label>
          <br></br>
          <input
            className="regInput"
            readOnly={!isEditable}
            value={userDetails.phone}
            onChange={(e)=>handleChange("phone",e.target.value)}
            type="text"
          />
        </div>
        <div className="m-5">
          {isEditable && (
            <button
              type="button"
              onClick={()=>handleEdit(false)}
              className="text-gray-900 bg-white border border-gray-300 focus:outline-none hover:bg-gray-100 focus:ring-4 focus:ring-gray-200 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-gray-800 dark:text-white dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 dark:focus:ring-gray-700"
            >
              Cancel
            </button>
          )}
          <button
            onClick={()=>handleEdit(true)}
            type="button"
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
          >
            {isEditable?"Save":"Edit"}
          </button>
        </div>
      </form>
      <div>
         <div>
          <button type="button" onClick={()=>navigationButton("add")}>Crete an Staff Account</button>
          </div>
          <div>
         <button onClick={()=>navigationButton("create")}>Staff Accounts</button>
          </div>
      </div>
    </div>
  );
};

export default Settings;
