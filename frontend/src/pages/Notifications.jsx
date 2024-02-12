import React from "react";

const Notifications = () => {
  return (
    <div>
      <h1 className="text-3xl font-bold mb-4">Request Matches</h1>
      <div className="w-[750px] h-[639px] rounded-3xl box-border border">
        <div className="bg-gray-100 shadow-md rounded px-4 py-6">
          <div className="flex items-center justify-between mb-2">
            <h2 className="text-xl font-semibold">
              Professional request for Job match
            </h2>
        
          </div>
          <div className="flex items-center justify-between">
            <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none">
              Match
            </button>
            <button className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded focus:outline-none">
              Reject
            </button>
          </div>
          <div className="flex items-center justify-between mb-2">
            <h2 className="text-xl font-semibold">
              Professional request for Job match
            </h2>
          </div>
          <div className="flex items-center justify-between">
            <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none">
              Match
            </button>
            <button className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded focus:outline-none">
              Reject
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Notifications;
