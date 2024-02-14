import React from "react";
import { FaUserTie } from 'react-icons/fa'; // react-icons for professional icon
import { BsBank } from "react-icons/bs";
import { IconContext } from 'react-icons';
import { useNavigate } from "react-router-dom";


const IndividualProfile = ({ OperationType, customerType }) => {
  const navigate = useNavigate();
  const category = [
    {
      type: "Experience :",
      keyword: "2 years in web development",
    },
    {
      type: "Skills :",
      keyword: "Java, Python, sql, aws",
    },
  ];
  const companyDetails = [
    {
      title: "Google",
      address: "Newyork",
    }
  ];
  
  const navigator =()=>{
       navigate("/home/individual?type="+customerType);
  }
  
  return (
    <div>
      <div className="bg-white p-4 m-2 border-spacing-3  rounded-lg shadow-2xl">
        <div className="flex justify-between mb-3">
      <div className="flex-shrink-0">
        {customerType=='Professional' ?
        (<FaUserTie className="h-12 w-12" />):<BsBank className="h-12 w-12" />
      }          
        </div>
        <h2 className="text-lg font-medium mb-4 flex justify-end bg-teal-300 p-2 rounded-md">{customerType}</h2>
        </div>
        <div className="flex items-center justify-between">
          <h4 className="text-xl font-semibold"> Username</h4>
        </div>
        {customerType == "Professional"
          ? category.map((item) => {
              return (
                <div className="mt-4">
                  <p className="mb-2 text-gray-800 font-medium">{item.type} {item.keyword}</p>
                  
                </div>
              );
            })
          : companyDetails.map((item) => {
              return (
                <div className="mt-4">
                  <p className="mb-2 text-gray-600">{item.title}</p>
                  <p className="font-medium">{item.address}</p>
                </div>
              );
            })}

        <div className="flex items-center justify-between mt-4">
          {OperationType == "review" && (
            <button className="bg-accept w-32 text-white px-4 py-2 hover:bg-green-600">
              
              Accept
            </button>
          )}

          <button onClick={navigator} className="bg-details w-32 text-black text- px-4 py-2 hover:bg-blue-600">
            Details
          </button>
        </div>
      </div>
    </div>
  );
};

export default IndividualProfile;
