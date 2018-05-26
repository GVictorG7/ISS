export function checkCompleted(object: any): boolean {
  let ok = true;
  for (const key of Object.keys(object)) {
    if (object.hasOwnProperty(key)) {
      if (object[key] && object[key].toString().trim() === '') {
        ok = false;
      }
    }
  }
  return ok;
}
