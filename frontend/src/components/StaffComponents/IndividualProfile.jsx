import React from 'react'

const IndividualProfile = () => {
  return (
    <div className='w-[337px] h-[239px] rounded-3xl box-border border'>
       <div className='flex flex-row'>
           <div>user image</div>
           <div>Empolyer</div>
       </div>
      <div>User name</div>
      <div>Category1: &nbsp; &nbsp;  2years in web </div>
      <div>Category2:  &nbsp; &nbsp;  java, python, sql, aws </div>
      <div className='flex'>
        <button className='bg-fbblue w-[160px] h-[36px] mr-2'>Accept</button>
        <button className='w-[153px] h-[36px] bg-[#c2c2c2]'>Details</button>
      </div>
    </div>
  )
}

export default IndividualProfile