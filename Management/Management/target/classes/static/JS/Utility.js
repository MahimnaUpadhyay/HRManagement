const openPopup = document.getElementById('addEmployeeButton');
const closePopup = document.getElementById('closePopup');
const popupContainer = document.getElementById('popupContainer');
const departmentSelection = document.getElementById('departmentSelection');
const tableBodyContainer = document.getElementById('tableBodyContainer');

function addEmployee(){
    openPopup.addEventListener('click', () => {
        popupContainer.classList.remove('hidden'); // Show popup
    });

    closePopup.addEventListener('click', () => {
        popupContainer.classList.add('hidden'); // Hide popup
    });

    document.addEventListener('click', (e) => {
        if (e.target === popupContainer) {
            popupContainer.classList.add('hidden');
        }
    });

    fetchDepartment();
}
addEmployee();

async function fetchEmployee() {
    try {
        const response = await axios.get("http://localhost:8080/getAllEmployees");
        const employee_data = response.data;
        tableBodyContainer.innerHTML = "";

        employee_data.forEach(employee => {
            const row = document.createElement("tr");
            row.classList.add("bg-gray-100", "border-b", "border-gray-400", "text-black");

            let departmentNames = "";
            let departmentHeads = "";

            if (Array.isArray(employee.departmentModel)) {
                departmentNames = employee.departmentModel.map(dep => dep.departmentName).join(", ");
                departmentHeads = employee.departmentModel.map(dep => dep.departmentHead).join(", ");
            }

            row.innerHTML = `
                <td class="px-6 py-3">${employee.employeeName}</td>
                <td class="px-6 py-3">${employee.employeeEmail}</td>
                <td class="px-6 py-3">${departmentNames}</td>
                <td class="px-6 py-3">${departmentHeads}</td>
                <td class="px-6 py-3">${employee.employeeRole}</td>
                <td class="px-6 py-3">₹ ${employee.employeeSalary}</td>
                <td class="px-6 py-3">
                    <button class="bg-red-500 text-white px-3 py-1 rounded-lg" onclick="deleteEmployee(${employee.id})">Delete</button>
                </td>
            `;

            tableBodyContainer.appendChild(row);
        });

    } catch (error) {
        console.error('Error fetching employees:', error);
    }
}
fetchEmployee();

async function fetchDepartment() {
    try {
        const request = await axios.get("http://localhost:8080/getAllDepartments");
        const department_data = request.data;
        console.log(department_data);
        departmentSelection.innerHTML = "";

        department_data.forEach(department => {
            const option = document.createElement("option");
            option.value = department.departmentID;
            option.textContent = department.departmentName;
            departmentSelection.appendChild(option);
        });
    } catch(error) {
        console.error('Error fetching Department: ', error);
    }
}
