import React from "react";

const StaffNotifications = () => {
  const notifications = [
    {
      userName: "professional",
      type: "jobRequest",
      companyName: "Google",
    },
    {
      userName: "professional2",
      type: "jobRequest",
      companyName: "Facebook",
    },
    {
      userName: "professional",
      type: "deleteRequest",
      companyName: null,
    },
    {
      userName: "empolyee",
      type: "deleteRequest",
      companyName: null,
    },
  ];
  return (
    <div>
      <h1 className="text-3xl font-bold mb-4">Notifcations</h1>
      <div className="w-[750px] h-[639px] rounded-3xl box-border border">
        <div className="bg-gray-100 shadow-md rounded px-4 py-6">
          {notifications.map((item) => {
            return (
              <div className="rounded-lg m-3 py-2 ">
                {item.type == "jobRequest" ? (
                  <>
                    <div className="flex items-center justify-between mb-2">
                      <p className="text-xl font-semibold">
                        {item.userName} has Requested for job match in
                        {item.companyName}
                      </p>
                    </div>
                    <div className="flex items-center justify-end">
                      <button className="bg-blue-500 mr-5 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none">
                        Match
                      </button>
                      <button className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded focus:outline-none">
                        Reject
                      </button>
                    </div>
                  </>
                ) : (
                  <>
                    <div className="flex items-center justify-between mb-2">
                      <p className="text-xl font-semibold">
                        {item.userName} has Requested for Deletion of an account
                      </p>
                    </div>
                    <div className="flex items-center justify-end">
                      <button className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded focus:outline-none">
                        Delete
                      </button>
                    </div>
                  </>
                )}
              </div>
            );
          })}
        </div>
      </div>
    </div>
  );
};

export default StaffNotifications;
