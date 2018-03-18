const upload = require("./programs");
module.exports = function (storageProvider) {
    return {
        resources: [
            {
                resource: "/programs",
                handler: upload(storageProvider("programs"))
            }
        ]
    }
};