import React from "react";
import Category from "../components/Category";

const IndividualDetails = () => {
  return (
    <div className="container  mx-auto px-4">
      <h1 className="text-3xl font-bold mb-4">Professional Details</h1>
      <div className="flex">
        <h2 className="text-xl font-semibold mb-2">User Name</h2>
        <br></br>
        <div className="grid grid-cols-2 gap-4">
          <div>
            <p className="text-gray-700 mb-1">First Name</p>
            <p>John</p>
          </div>
          <div>
            <p className="text-gray-700 mb-1">Last Name</p>
            <p>Doe</p>
          </div>
        </div><br></br>
        <div className="mb-4">
            <p className="text-gray-700 mb-1">Address</p>
            <p>5657, McFartein Blvd, Dallas, Texas, United States</p>
          </div>
          <div className="mb-4">
            <p className="text-gray-700 mb-1">Email</p>
            <p>profesional@gmail.com</p>
          </div>
          <div className="mb-4">
            <p className="text-gray-700 mb-1">Phone Number</p>
            <p>1234567890</p>
          </div>
      </div>
    </div>
  );
};

export default IndividualDetails;
