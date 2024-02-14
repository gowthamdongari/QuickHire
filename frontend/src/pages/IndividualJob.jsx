import React from 'react'
import JobPosting from '../components/Employer/JobPosting'
import { useParams } from 'react-router-dom'

const IndividualJob = () => {
  return (
    <div>
       <JobPosting isView={true}/>
    </div>
  )
}

export default IndividualJob
