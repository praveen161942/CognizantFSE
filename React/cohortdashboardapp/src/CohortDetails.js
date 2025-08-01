import React from 'react';

function CohortDetails({ cohort }) {
  return (
    <div>
      <h3>{cohort?.cohortCode}</h3>
      <p>{cohort?.title}</p>
      <p>{cohort?.duration}</p>
    </div>
  );
}

export default CohortDetails;