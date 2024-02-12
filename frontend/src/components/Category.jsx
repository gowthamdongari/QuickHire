import React from "react";
import { useState } from "react";

const Category = () => {
  const data = [
    { category: "Technology", keywords: "React, JavaScript, Tailwind CSS" },
    { category: "Food", keywords: "Pizza, Sushi, Burger" },
    { category: "Sports", keywords: "Football, Basketball, Tennis" },
  ];

  return (
    <>
      <form className="flex flex-row">
        <div className="flex flex-col">
          <label>Enter Category</label>
          <br />
          <input placeholder="company name" type="text" />
        </div>
        <div className="flex flex-col ml-10">
          <label>Enter Keywords or Description</label>
          <input placeholder="Keywords" type="text" />
        </div>
      </form>
      <div className="container mx-auto">
        <table className="min-w-full divide-y divide-gray-200">
          <thead className="bg-gray-50">
            <tr>
              <th
                scope="col"
                className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
              >
                Category
              </th>
              <th
                scope="col"
                className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
              >
                Keywords
              </th>
            </tr>
          </thead>
          <tbody className="bg-white divide-y divide-gray-200">
            {data.map((item, index) => (
              <tr key={index}>
                <td className="px-6 py-4 whitespace-nowrap">
                  <div className="text-sm text-gray-900">{item.category}</div>
                </td>
                <td className="px-6 py-4 whitespace-nowrap">
                  <div className="text-sm text-gray-900">{item.keywords}</div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default Category;
