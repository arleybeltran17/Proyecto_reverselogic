let updateButtons = document.querySelectorAll(".btncal");

updateButtons.forEach(function(button) {
    button.addEventListener("click", function() {
        let modal = document.getElementById("myModal1");
        let form = modal.querySelector("form");

        // Obtener los valores ingresados por el usuario en la tarjeta
        let EmpleId = button.getAttribute("data-emple-id");
        let EmpleTipoDoc = button.parentElement.querySelector(".cardEmpleTipoDoc").textContent;
        let EmpleNumDoc= button.parentElement.querySelector(".cardEmpleNumDoc").textContent;
        let EmpleNombre = button.parentElement.querySelector(".cardEmpleNombre").textContent;
        let EmpleApellido = button.parentElement.querySelector(".cardEmpleApellido").textContent;
        let EmpleCargo = button.parentElement.querySelector(".cardEmpleCargo").textContent;
        let EmpleDireccion = button.parentElement.querySelector(".cardEmpleDireccion").textContent;
        let EmpleEmail = button.parentElement.querySelector(".cardEmpleEmail").textContent;

        // Llenar los campos en la ventana modal con los valores obtenidos
        form.Emple_Id.value = EmpleId;
        form.Emple_Tipo_Doc.value = EmpleTipoDoc;
        form.Emple_Num_Doc.value = EmpleNumDoc;
        form.Emple_Nombre.value = EmpleNombre;
        form.Emple_Apellido.value = EmpleApellido;
        form.Emple_Cargo.value = EmpleCargo;
        form.Emple_Direccion.value = EmpleDireccion;
        form.Emple_Email.value = EmpleEmail;

        // Mostrar la ventana modal
        modal.style.display = "block";
    });
});

// Aquí, getUserById() es una función ficticia, debes implementarla para obtener los datos del usuario por su ID
function getEmpleById(EmpleId, callback) {
    // Aquí, realiza una solicitud AJAX al servidor o cualquier otra lógica para obtener los datos del usuario
    // Supongamos que userData es un objeto que contiene la información del usuario por su ID
    let EmpleData = {
        Emple_Id: EmpleId,
        Emple_Tipo_Doc: EmpleTipoDoc,
        Emple_Num_Doc: EmpleNumDoc,
        Emple_Nombre: EmpleNombre,
        Emple_Apellido: EmpleApellido,
        Emple_Cargo: EmpleCargo,
        Emple_Direccion: EmpleDireccion,
        Emple_Email: Emple_Email
    };

    // Llamar al callback con los datos del usuario
    callback(EmpleData);
}

// Evento de cierre de la ventana modal
let modal = document.getElementById("myModal1");
let closeBtn = document.querySelector(".close1");

closeBtn.addEventListener("click", function() {
    modal.style.display = "none";
});

window.addEventListener("click", function(event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
});