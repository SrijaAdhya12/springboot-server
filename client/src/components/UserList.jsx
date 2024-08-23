import React, { useState } from 'react'
import axios from 'axios'

const UserList = () => {
	const [users, setUsers] = useState([])
	const [newUserName, setNewUserName] = useState('')

	const fetchUsers = async () => {
		try {
			const response = await axios.get(`${import.meta.env.VITE_API}/users`)
			setUsers(response.data)
		} catch (error) {
			console.error('Error fetching users:', error)
		}
	}

	const createUser = async () => {
		if (newUserName.trim() === '') {
			alert('Please enter a name.')
			return
		}
		try {
			const response = await axios.post(`${import.meta.env.VITE_API}/users`, {
				name: newUserName
			})
			setUsers((prevUsers) => [...prevUsers, response.data])
			setNewUserName('')
		} catch (error) {
			console.error('Error creating user:', error)
		}
	}

	return (
		<div className="p-4">
			<h1 className="text-2xl font-bold mb-4">User List</h1>
			<table className="min-w-full bg-white border border-gray-200 rounded-lg shadow-md">
				<thead>
					<tr>
						<th className="py-2 px-4 border-b">ID</th>
						<th className="py-2 px-4 border-b">Name</th>
					</tr>
				</thead>
				<tbody>
					{users.map((user) => (
						<tr key={user.id}>
							<td className="py-2 px-4 border-b">{user.id}</td>
							<td className="py-2 px-4 border-b">{user.name}</td>
						</tr>
					))}
				</tbody>
			</table>
			<div className="flex gap-6 my-5">
				<div className="mb-4">
					<input
						type="text"
						value={newUserName}
						onChange={(e) => setNewUserName(e.target.value)}
						placeholder="Enter user name"
						className="mr-2 px-4 py-2 border border-gray-300 rounded"
					/>
					<button
						onClick={createUser}
						className="px-4 py-2 bg-green-500 text-white rounded hover:bg-green-600"
					>
						Create New User
					</button>
				</div>
				<button
					onClick={fetchUsers}
					className="mb-4 px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600"
				>
					Get All Users
				</button>
			</div>
		</div>
	)
}

export default UserList
