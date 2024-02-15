import React from "react";
import { useLocation, useNavigate } from "react-router-dom";

function useQuery(){
  const {search} = useLocation();
  return React.useMemo(()=>new URLSearchParams(search),[search]);
}

const RegistrationPage = () => {
  const query = useQuery();
  const customerType = query.get("type");
  const navigation = useNavigate();
 
  const handleNavigation = () =>{
      if(customerType=="Professional"){
         navigation("/education");
      }
  }
  return (
    <div className="bg-gray-50 min-h-screen flex justify-center w-full">
      <div className="bg-white rounded-lg shadow-lg p-8 m-4 max-w-2xl w-full">
          <div className='flex justify-center'>
            <h1 className="text-md font-semibold mb-4">{customerType}Registration</h1>
            </div>
            <div className='flex justify-center'>
            <p className="text-xs font-semibold mb-4">Enter Your Details to continue</p>
            </div>
          <div className="flex flex-wrap -mx-2 mb-2">
          <div className="w-full md:w-1/2 px-2 mb-2 md:mb-0">
          <h1 className="text-xs font-semibold mb-2">First Name</h1>
          <input
            className="mb-2 w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
            type="text"
            id="firstName"
            placeholder="First Name"
          />
        </div>
        <div className="w-full md:w-1/2 px-2 mb-2 md:mb-0">
          <h1 className="text-xs font-semibold mb-2">Last Name</h1>
          <input
            className="mb-2 w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
            type="text"
            id="firstName"
            placeholder="Last Name"
          />
        </div>
        </div>
        <div className="flex flex-wrap -mx-2 mb-2">
          {customerType=="Employer" &&<div className="w-full md:w-1/2 px-2 mb-2 md:mb-0">
          <h1 className="text-xs font-semibold mb-2">Company name</h1>
          <input
            className="mb-2 w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
            type="text"
            id="company name"
            placeholder="Enter the company name"
          />
        </div>}
        <div className="w-full md:w-1/2 px-2 mb-2 md:mb-0">
          <h1 className="text-xs font-semibold mb-2">Preferred Username</h1>
          <input
            className="mb-2 w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
            type="text"
            id="Preferred Username"
            placeholder="Create your unique Username Name"
          />
        </div>
        </div>
        <div className="flex flex-wrap -mx-2 mb-2">
          <div className="w-full md:w-1/2 px-2 mb-2 md:mb-0">
          <h1 className="text-xs font-semibold mb-2">Email</h1>
          <input
            className="mb-2 w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
            type="text"
            id="Email"
            placeholder="Enter your mail Address"
          />
        </div>
        <div className="w-full md:w-1/2 px-2 mb-2 md:mb-0">
          <h1 className="text-xs font-semibold mb-2">Phone No</h1>
          <input
            className="mb-2 w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
            type="text"
            id="Phone No"
            placeholder="Enter your phone number"
          />
        </div>
        </div>
        <div className="w-full md:w-full px-2 -mx-2 mb-2 md:mb-0">
          <h1 className="text-xs font-semibold mb-2">Mailing Address</h1>
          <input
            className="mb-2 w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
            type="text"
            id="Mailing Address"
            placeholder="Enter your mail Address"
          />
        </div>
        <div className="flex flex-wrap -mx-2 mb-2">
            <div className="w-full md:w-1/3 px-2 mb-2 md:mb-0">
                <h1 className='text-xs font-semibold mb-2'>City</h1>
                <input
                className="passwordinput text-grey-darker"
                type="text"
                placeholder="City"
                />
            </div>
            <div className="w-full md:w-1/3 px-2">
                <h1 className='text-xs font-semibold mb-2'>State</h1>
                <input
                className="passwordinput text-grey-darker"
                type="text"
                placeholder="State"
                />
            </div>
            <div className="w-full md:w-1/3 px-2">
                <h1 className='text-xs font-semibold mb-2'>Zipcode</h1>
                <input
                className="passwordinput text-grey-darker"
                type="text"
                placeholder="Zipcode"
                />
            </div>
            </div>
            <div className="flex items-center justify-between mt-8 mb-8">
                <div className="flex-1 ml-3 text-xs">
                    <button type="button" onClick={handleNavigation} className="item-center bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded-full w-1/2">
                    {customerType=="Professional"?"Save & Continue":"Register"}
                    </button>
                </div>
            </div>
            </div>
    </div>
    
  );
};

export default RegistrationPage;
