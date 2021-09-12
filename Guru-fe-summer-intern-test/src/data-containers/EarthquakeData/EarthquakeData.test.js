import React from 'react';
import nock from 'nock';
import { shallow } from 'enzyme';

import EarthquakeData from './EarthquakeData';
import mockEarthquakeData from '../../../__mocks__/mockEarthquakeData';

const MockComponent = EarthquakeData(() => <div />);

describe('data-container - EarthquakeData', () => {
  beforeEach(() => {
    global.api = nock('http://interviewtest.getguru.com')
      .get('/seismic/data.json')
      .reply(200, mockEarthquakeData);
  });

  it('Attempts to fetch the data from the correct endpoint in componentDidMount', async () => {
    const comp = shallow(<MockComponent />);
    await comp.instance().componentDidMount();

    expect(global.api.isDone()).toBe(true);
  });
});
