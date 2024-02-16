import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const StaffSettings = () => {
  const [isEditable, setIsEditable] = useState(false);
  const [userDetails, setUserDetails] = useState({
    email: "staff@quickhire.com",
    phone: "909999999",
  });
  const navigate = useNavigate();
  const handleEdit = (val) => {
    setIsEditable(val);
    console.log(isEditable);
    if (val == false) {
      setUserDetails({ email: "staff@quickhire.com", phone: "909999999" });
    }
  };
  const handleChange = (key, val) => {
    setUserDetails({ ...userDetails, [key]: val });
  };

  const navigationButton = (val) => {
    if (val == "add") {
      navigate("createAccount");
    } else {
      navigate("staffAccounts");
    }
  };

  return (
    <div className="bg-gray-50 min-h-screen flex justify-center w-full">
      <div className="bg-white rounded-lg shadow-lg p-8 m-4 max-w-xl w-1/2">
        <h1 className="flex justify-center text-lg font-semibold mb-4">
          Account Settings
        </h1>
        <div className="m-4">
          <label className="text-xs font-semibold mb-4">Email:</label>
          <input
            className="passwordinput text-grey-darker"
            readOnly={!isEditable}
            value={userDetails.email}
            onChange={(e) => handleChange("email", e.target.value)}
            type="text"
          />
        </div>
        <div className="m-4">
          <label className="text-xs font-semibold mb-4">Phone:</label>
          <input
            className="passwordinput text-grey-darker"
            readOnly={!isEditable}
            value={userDetails.phone}
            onChange={(e) => handleChange("phone", e.target.value)}
            type="text"
          />
        </div>
        <div className="m-4 flex justify-center">
          {isEditable && (
            <button
              type="button"
              onClick={() => handleEdit(false)}
              className="text-gray-900 bg-white border border-gray-300 focus:outline-none hover:bg-gray-100 focus:ring-4 focus:ring-gray-200 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-gray-800 dark:text-white dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 dark:focus:ring-gray-700"
            >
              Cancel
            </button>
          )}
          <button
            onClick={() => handleEdit(true)}
            type="button"
            className="flex w-full justify-center rounded-md bg-fbblue px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
          >
            {isEditable ? "Save" : "Edit"}
          </button>
        </div>
      </div>
    </div>
  );
};

export default StaffSettings;
