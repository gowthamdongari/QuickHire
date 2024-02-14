import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import CategoryList from "./CategoryList";

const mystyle = {
  Header: {
    color: "#5856d6",
    fontsize: "48px",
    fontFamily: "Roboto Slab",
    fontWeight: "500",
    lineHeight: "62px",
    textAlign: "center",
  },
  Registration: {
    color: "#3a3a3a",
    fontSize: "40px",
    fontFamily: "Source Sans Pro",
    fontWeight: 700,
    lineHeight: "38px",
    textAlign: "center",
  },
  Para: {
    color: "#3a3a3a",
    fontSize: "18px",
    fontFamily: "Source Sans Pro",
    lineHeight: "31px",
    textAlign: "center",
  },
};
const Category = () => {
  const [category, setCategory] = useState({ type: "", keywords: "" });
  const [categoryList, setCategoryList] = useState([]);
  const navigation = useNavigate();
  const handleChange = (key, val) => {
    setCategory({ ...category, [key]: val });
  };
  const isShowHeader = false;
   
  const handleAdd = () => {
    if (categoryList.length > 0) {
      setCategoryList([...categoryList, category]);
    } else {
      setCategoryList([category]);
    }
    console.log(categoryList);
    console.log(category);
    setCategory({ type: "", keywords: "" });
  };
  return (
    <div>{isShowHeader &&
      <div>
      <h1 style={mystyle.Header}>QuickHire</h1>
      <h3 style={mystyle.Registration}>Professional Registration</h3>
      <p style={mystyle.Para}>
        Enter your Role Specific Category details to continue
      </p>
      </div>}
      <div>
        <form >
          <div className="flex flex-row gap-5 ml-8">
            <div>
              <label>Category Type:</label>
              <br></br>
              <input
                value={category.type}
                onChange={(e) => handleChange("type", e.target.value)}
                placeholder="Enter your Category Type"
                type="text"
              />
            </div>
            <div>
              <label>Keywords</label>
              <br></br>
              <input
                placeholder="Enter your keywwords"
                value={category.keywords}
                onChange={(e) => handleChange("keywords", e.target.value)}
                type="text"
              />
            </div>
            <div className="mt-6">
              <button
                type="button"
                onClick={handleAdd}
                className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
              >
                add
              </button>
            </div>
          </div>
          {
             categoryList.length>0 && (
              <div className="w-[600px] h-fit mt-6">
                < CategoryList categoryList={categoryList}/>
              </div>
             )
          }
          <div className="mt-7">
            {categoryList.length > 1 && (
              <button
                onClick={() => navigation("/home")}
                className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
              >
                Finish
              </button>
            )}
          </div>
        </form>
      </div>
    </div>
  );
};

export default Category;
