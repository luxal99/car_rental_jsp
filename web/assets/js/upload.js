async function upload() {
    let photo = document.getElementById("image-file").files[0];
    let formData = new FormData();

    formData.append("photo", photo);

    try {
        let r = await fetch('../img/', {method: "POST", body: formData});
        console.log('HTTP response code:', r.status);
    } catch (e) {
        console.log('Huston we have problem...:', e);
    }
}