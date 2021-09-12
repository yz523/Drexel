/**
 * This is the function that should sort, filter, and slice the earthquakes
 * whenever neccessary.  Refer to the README.md for how this should specifically be done.
 *
 * @param {string} filter
 * @param {array} earthquakes
 */

export default function organizeEarthquakes(filter, earthquakes) {
  // sort
  const sorted = earthquakes.sort(
    // Highest magnitude to lowest magnitude
    // If they are the same sort by time from latest to oldest
    (a, b) => b.mag - a.mag || new Date(b.time) - new Date(a.time)
  );

  // filter
  if (filter !== '') {
    // After sorting and filtering the earthquakes, show no more than 20 results
    // filters without case affecting the results
    const f = filter.toLowerCase();
    return sorted.filter(e => e.place.toLowerCase().includes(f)).slice(0, 20);
  }
  return sorted.slice(0, 20);
}
