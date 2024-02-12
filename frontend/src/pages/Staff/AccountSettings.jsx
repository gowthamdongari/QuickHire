import React from "react";

const AccountSettings = () => {
  return (
    <div>
      <h2>Account Settings</h2>
      <form>
        <div>
          <label>Email</label>
          <br></br>
          <input
            className="w-[468px] h-[48px] p-1 box-border rounded-3xl bg-[#f2f2f2]"
            placeholder="Please Enter your Email Details"
            type="email"
          />
        </div>
        <div>
          <br></br>
          <br></br>
          <label>Phone No</label>
          <br></br>
          <input
            className="w-[468px] h-[48px] p-1 box-border rounded-3xl bg-[#f2f2f2]"
            placeholder="Please Enter your New Phone Details"
            type="text"
          />
        </div>
      </form>
      <div className="mt-10">
        <button className="w-[468px] h-[48px] rounded-3xl bg-[#e22823] decoration-[#ffffff] ">
          Modify
        </button>
      </div>
    </div>
  );
};

export default AccountSettings;
