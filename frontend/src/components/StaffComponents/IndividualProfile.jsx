import React from "react";

const IndividualProfile = ({ OperationType, customerType }) => {
  const category = [
    {
      type: "Experience",
      keyword: "2 years in web development",
    },
    {
      type: "Skills",
      keyword: "Java, Python, sql, aws",
    },
  ];
  const companyDetails = [
    {
      title: "Google",
      address: "Newyork",
    }
  ];
  return (
    <div>
      <div className="bg-white p-4 m-2 rounded-lg shadow-2xl">
        <h2 className="text-lg font-medium mb-4">{customerType}</h2>
        <div className="flex items-center justify-between">
          <h4 className="text-xl font-semibold">{customerType} Username</h4>
        </div>
        {customerType == "Professional"
          ? category.map((item) => {
              return (
                <div className="mt-4">
                  <p className="mb-2 text-gray-600">{item.type}</p>
                  <p className="font-medium">{item.keyword}</p>
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
            <button className="bg-green-500 text-white px-4 py-2 rounded-md hover:bg-green-600">
              Accept
            </button>
          )}

          <button className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600">
            Details
          </button>
        </div>
      </div>
    </div>
  );
};

export default IndividualProfile;
