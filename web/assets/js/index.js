function selectCarBrand() {
    const carBrandList = document.getElementById("carBrandId");
    const value = carBrandList.options[carBrandList.selectedIndex].value;
    localStorage.setItem("carBrand", value);
}

window.onload = function () {
    document.getElementById('carBrandId').value = localStorage.getItem('carBrand');
}