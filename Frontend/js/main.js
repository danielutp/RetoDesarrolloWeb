const section_tareas = document.querySelector('.cont_tareas');
const form = document.querySelector('#form')
const btn = document.querySelector('#btnCrear')
let url = 'http://localhost:8080'

btn.addEventListener("click", (e) => {    
    crearTarea(document.querySelector('#tarea').value)
})

const mostrar = (tareas) => {
    resultados = ''    
    tareas.forEach(tarea => {
        resultados += `<tr>
                            <td>${usuario.id}</td>
                            <td>${usuario.nombre}</td>
                            <td>${usuario.email}</td>
                            <td>${usuario.prioridad}</td>
                            <td class="text-center"><a class="btnEditar btn btn-primary">Editar</a><a class="btnBorrar btn btn-danger">Borrar</a></td>
                       </tr>
                    `    
    })    
    contenedor.innerHTML = resultados
    
}

///CRUD TAREAS

async function mostrarTarea(){

    let res = await fetch(`${url}/api/tareas`)

    let data = await res.json()
    console.log(data)    
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
    plasmarTareas()    
}

async function eliminarTarea(id){
    
    let options = {
      method: "DELETE",
      headers: {
        "Content-type": "application/json; charset=utf-8"
      },     
    },
      res = await fetch(`${url}/api/tarea/${id}`, options)
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
