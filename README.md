# Sistema de Gestión de Estudiantes

Este proyecto en Java es un sistema sencillo pero completo para gestionar estudiantes en una institución educativa. Permite agregar, listar, eliminar, buscar estudiantes por nombre y calcular promedios generales.

---

## Funcionalidades

1. **Agregar Estudiante**
   - Registra estudiantes con:
     - ID
     - Nombre (con corrección automática de mayúsculas)
     - Edad
     - Género
     - Promedio de calificaciones
   - Determina automáticamente si el estudiante está **APROBADO** o **REPROBADO**.

2. **Listar Estudiantes**
   - Permite navegar entre los estudiantes registrados uno por uno.
   - Muestra todos los datos importantes: ID, nombre, edad, género, estado y promedio.

3. **Eliminar Estudiante**
   - Permite eliminar estudiantes por índice.
   - Puedes ver los datos antes de confirmar la eliminación.

4. **Buscar Estudiante por Nombre**
   - Busca coincidencias exactas o por prefijo.
   - Permite ver datos o eliminar el estudiante encontrado.

5. **Calcular Promedio General**
   - Calcula el promedio de todos los estudiantes registrados.

---

## Estructura del Proyecto

- `src/Funciones/Agregar_Estudiante/`
  - Clases para manejar estudiantes: `Estudiante`, `Agregar_Estudiante`, `ManejoDeErrores`, `Estados`.
- `src/Funciones/BuscarEstudiantePorNombre/`
  - Clase para búsqueda de estudiantes por nombre.
- `src/Funciones/CalcularPromedioGeneral/`
  - Clase para calcular promedio general.
- `src/Funciones/EliminarEstudiante/`
  - Clase para eliminar estudiantes.
- `src/Funciones/ListarEstudiantes/`
  - Clase para listar estudiantes.
- `src/Menu_Principal/`
  - Clase principal del menú interactivo.
- `src/Main/`
  - Clase `Main` que inicia el programa.

---

## Cómo Usar

1. Clona el repositorio:
```bash
git clone https://github.com/RoMiYR/Proyecto-de-gestion-de-estudiantes.git
