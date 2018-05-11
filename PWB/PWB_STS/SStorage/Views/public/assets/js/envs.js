/**
 * Callback the User Register Operation
 * @param {Response} response 
 * @param {HTMLFormElement} form 
 */
function handleRegisterEnv(response, form) {
    if (response.ok) {
        window.location.href = ROUTES["router-envs"];
    } else {
        let customHeaderKeys = Array.from(response.headers.keys()).filter(function (key) {
            return key.toLowerCase().startsWith("x-")
        });
        for (let key of customHeaderKeys) {
            let message = response.headers.get(key);
            addFormError(form, key.substr(2), message);
        }
    }
}