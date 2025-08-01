import React from 'react';
import { shallow, mount } from 'enzyme';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';

describe('Cohort Details Component', () => {
  test('should create the component', () => {
    const wrapper = shallow(<CohortDetails />);
    expect(wrapper.exists()).toBeTruthy();
  });

  test('should initialize the props', () => {
    const wrapper = mount(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper.props().cohort).toEqual(CohortData[0]);
  });

  test('should display cohort code in h3', () => {
    const wrapper = mount(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper.find('h3').text()).toBe(CohortData[0].cohortCode);
  });

  test('should always render same html', () => {
    const wrapper = shallow(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper).toMatchSnapshot();
  });
});