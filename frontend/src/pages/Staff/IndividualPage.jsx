import React from 'react'
import ProfessionalDetails from '../../components/ProfessionalProfile/ProfessionalDetails';
import { useLocation } from 'react-router-dom';

function useQuery(){
  const {search} = useLocation();
  return React.useMemo(()=>new URLSearchParams(search),[search]);
}

const IndividualPage = () => {
  const query = useQuery();
  const customerType = query.get("type");
  const operationType = query.get("op");
  console.log(customerType,operationType)
  return (
    <div>
       <ProfessionalDetails customerType={customerType} operationType={operationType}/>
    </div>
  )
}

export default IndividualPage



