import React from "react";

const CategoryList = ({categoryList}) => {
  return (
    <div className="overflow-x-auto">
      <table className="table-auto w-full border-collapse border border-gray-800">
        <thead>
          <tr className="bg-gray-200">
            <th className="border border-gray-800 px-4 py-2">Category Type</th>
            <th className="border border-gray-800 px-4 py-2">Keywords</th>
          </tr>
        </thead>
        <tbody>
          {categoryList.map((item, index) => (
            <tr
              key={index}
              className={index % 2 === 0 ? "bg-gray-100" : "bg-white"}
            >
              <td className="border border-gray-800 px-4 py-2">{item.type}</td>
              <td className="border border-gray-800 px-4 py-2">
                {item.keywords}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default CategoryList;
