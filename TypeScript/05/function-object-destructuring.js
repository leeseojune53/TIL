"use strict";
function printProfile(_a) {
    var _b = _a === void 0 ? { name: "anonymous" } : _a, name = _b.name, _c = _b.nationality, nationality = _c === void 0 ? "none" : _c;
    console.log(name, nationality);
}
printProfile();
printProfile({ name: "happy" });
printProfile({ name: "happy", nationality: "korea" });
