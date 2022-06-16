const section_tareas = document.querySelector('.cont_tareas');
const form = document.querySelector('#form')
const btn = document.querySelector('#btnCrear')
let url = 'http://localhost:8080'

section_tareas.addEventListener("click", (e) => {
  if (e.target.classList[0] == "EliminarTarea") {
    eliminarTarea(e.target.previousElementSibling.textContent)
  }else{
    modificarSubTarea(e.target.previousElementSibling.textContent)
  } 
})

btn.addEventListener("click", (e) => {    
    crearTarea(document.querySelector('#tarea').value)
})



const plasmarTareas = (tareas) => {
    let resultados = ''
    let subta = ''
    tareas.forEach(tarea => {
      console.log(tarea)
      tarea.subtareas.forEach(subtarea => {
        subta += `
        <tr class="table-light">
                    <th scope="row">${subtarea.id}</th>
                    <td>${subtarea.nombre}</td>
                    <td><div class="form-check form-switch">
                        <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault">                        
                      </div></td>
                    <td><button type="submit" id="btnEditarSub" class="btn btn-info">Editar</button></td>
                    <td><button type="submit" id="btnEliminarSub" class="btn btn-danger">Eliminar</button></td>                                 
                  </tr>        
        `
      })
        resultados += `
        <div class="containerTarea card border-primary mb-3">
                <div class="cabezaTarea">
                    <h2>${tarea.nombre}</h2>
                    <spam class = "spamId">${tarea.id}</spam>
                    <button type="submit" id="btnEliminar${tarea.id}" class="EliminarTarea btn btn-danger">Eliminar</button>
                    <input type="text" class="form-control" id="subtarea" aria-describedby="crear subtarea" placeholder="Subtarea">                    
                    <button type="submit" id="btnCrearSubtarea${tarea.id}" class="btn btn-primary">Agregar</button>
                </div>                        
              <table class="table table-hover">
                <thead>
                  <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Nombre SubTarea</th>
                    <th scope="col">Completado?</th>                                  
                  </tr>
                </thead>
                <tbody>
                ${subta}
                </tbody>                              
              </table>              
            </div>
                    `    
    })    
    section_tareas.innerHTML = resultados    
}

///CRUD TAREAS

async function mostrarTarea(){

    let res = await fetch(`${url}/api/tareas`)

    let data = await res.json()
    console.log(data)
    plasmarTareas(data)     
}

mostrarTarea()

async function crearTarea(nombre){
    
    let options = {
      method: "POST",
      headers: {
        "Content-type": "application/json; charset=utf-8"
      },
      body: JSON.stringify({
        nombre: nombre
        
      })
    },
      res = await fetch(`${url}/api/tarea`, options)
      mostrarTarea()             
}

async function eliminarTarea(id){
    
    let options = {
      method: "DELETE",
      headers: {
        "Content-type": "application/json; charset=utf-8"
      },     
    },
      res = await fetch(`${url}/api/tarea/${id}`, options)
      mostrarTarea()
}

///CRUD SUBTAREAS

async function crearSubTarea(){
    
    let options = {
      method: "POST",
      headers: {
        "Content-type": "application/json; charset=utf-8"
      },
      body: JSON.stringify({        
            tarea: {
                id: 6
            },
            nombre: "pruebasubtarea"                 
                 
      })
    },
      res = await fetch(`${url}/api/subtarea`, options)

}

async function modificarSubTarea(id){
    
    let options = {
      method: "PUT",
      headers: {
        "Content-type": "application/json; charset=utf-8"
      },
      body: JSON.stringify({        
            tarea: {
                id: 6
            },
            nombre: "pruebassssssa"                 
                 
      })
    },
      res = await fetch(`${url}/api/subtarea/${id}`, options)
}

async function eliminarSubTarea(id){
    
    let options = {
      method: "DELETE",
      headers: {
        "Content-type": "application/json; charset=utf-8"
      },     
    },
      res = await fetch(`${url}/api/subtarea/${id}`, options)
}
