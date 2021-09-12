import React, { PureComponent } from 'react';
import PropTypes from 'prop-types';
import classNames from 'classnames';

import 'components/EarthquakeDetailsButton/EarthquakeDetailsButton.css';

export default class EarthquakeDetailsButton extends PureComponent {
  render() {
    const { active, onClick } = this.props;
    const buttonClass = classNames('EarthquakeDetailsButton', {
      'is-active': active,
    });

    return (
      <button className={buttonClass} onClick={onClick}>
        Details
      </button>
    );
  }
}

EarthquakeDetailsButton.propTypes = {
  onClick: PropTypes.func,
  active: PropTypes.bool,
};

EarthquakeDetailsButton.defaultProps = {
  onClick: () => {},
  active: false,
};
