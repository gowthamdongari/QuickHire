import React from 'react'

const PasswordChange = () => {
  return (
    <div className="bg-gray-50 min-h-screen flex justify-center w-full">
        <div className="bg-white rounded-lg shadow-lg p-8 m-4 max-w-xl w-1/2">
            <h1 className="text-xs font-semibold mb-4">Current Password</h1>
            <input
            className="passwordinput text-grey-darker"
            type="password"
            placeholder="Current Password"
            />
            <h1 className="text-xs font-semibold mb-4">New Password</h1>
            <input
            className="passwordinput text-grey-darker"
            type="password"
            placeholder="New Password"
            />
            <h1 className="text-xs font-semibold mb-4">Confirm Password</h1>
            <input
            className="passwordinput text-grey-darker"
            type="password"
            placeholder="Confirm Password"
            />
            <div className="flex items-center justify-between mt-8 mb-8">
                <div className="flex-1 ml-3 text-xs">
                    <button className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded-full w-full">
                    Save & Finish
                    </button>
                </div>
            </div>
        </div>
        </div>
  )
}

export default PasswordChange
