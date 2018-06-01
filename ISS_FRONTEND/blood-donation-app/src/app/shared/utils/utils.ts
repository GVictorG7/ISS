export function checkCompleted(object: any): boolean {
  let ok = true;
  for (const key of Object.keys(object)) {
    console.log(key);
    if (object.hasOwnProperty(key)) {
      if (object[key].toString().trim() === '') {
        ok = false;
      }
    }
  }
  return ok;
}
export function dateAsString(requestDate) {
  return `${requestDate.dayOfMonth} ${requestDate.month} ${requestDate.year}`;
}
