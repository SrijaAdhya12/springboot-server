import React, { useState } from 'react'
import axios from 'axios'

const UserList = () => {
	const [users, setUsers] = useState([])
	const [newUserName, setNewUserName] = useState('')
	const [modalVisible, setModalVisible] = useState(false)
	const [updateName, setUpdateName] = useState('')
	const [updateId, setUpdateId] = useState(null)

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

	const updateUser = async () => {
		if (updateName.trim() === '') {
			alert('Please enter a name.')
			return
		}
		try {
			const response = await axios.put(`${import.meta.env.VITE_API}/users/${updateId}`, {
				name: updateName
			})
			setUsers((prevUsers) => prevUsers.map((user) => (user.id === updateId ? response.data : user)))
			setModalVisible(false)
			setUpdateName('')
			setUpdateId(null)
		} catch (error) {
			console.error('Error updating user:', error)
		}
	}

	const deleteUser = async (id) => {
		try {
			await axios.delete(`${import.meta.env.VITE_API}/users/${id}`)
			setUsers((prevUsers) => prevUsers.filter((user) => user.id !== id))
		} catch (error) {
			console.error('Error deleting user:', error)
		}
	}

	const openUpdateModal = (user) => {
		setUpdateId(user.id)
		setUpdateName(user.name)
		setModalVisible(true)
	}

	const closeUpdateModal = () => {
		setModalVisible(false)
		setUpdateName('')
		setUpdateId(null)
	}

	return (
		<div className="p-4 max-w-screen-lg mx-auto">
			<h1 className="text-2xl font-bold mb-4 text-center">User List</h1>
			<div className="overflow-x-auto">
				<table className="min-w-full bg-white border border-gray-200 rounded-lg shadow-md">
					<thead>
						<tr>
							<th className="py-2 px-4 border-b text-left">ID</th>
							<th className="py-2 px-4 border-b text-left">Name</th>
							<th className="py-2 px-4 border-b text-left">Actions</th>
						</tr>
					</thead>
					<tbody>
						{users.map((user) => (
							<tr key={user.id}>
								<td className="py-2 px-4 border-b">{user.id}</td>
								<td className="py-2 px-4 border-b">{user.name}</td>
								<td className="py-2 px-4 border-b">
									<button
										onClick={() => openUpdateModal(user)}
										className="px-2 py-1 bg-yellow-500 text-white rounded hover:bg-yellow-600"
									>
										Update
									</button>
									<button
										onClick={() => deleteUser(user.id)}
										className="ml-2 px-2 py-1 bg-red-500 text-white rounded hover:bg-red-600"
									>
										Delete
									</button>
								</td>
							</tr>
						))}
					</tbody>
				</table>
				<div className="flex flex-col sm:flex-row sm:items-center gap-4 mb-4 py-4">
					<div className="flex flex-col sm:flex-row items-center gap-2">
						<input
							type="text"
							value={newUserName}
							onChange={(e) => setNewUserName(e.target.value)}
							placeholder="Enter user name"
							className="px-4 py-2 border border-gray-300 rounded w-full sm:w-auto"
						/>
						<button
							onClick={createUser}
							className="mt-2 sm:mt-0 px-4 py-2 bg-green-500 text-white rounded hover:bg-green-600 w-full sm:w-auto"
						>
							Create New User
						</button>
					</div>
					<button
						onClick={fetchUsers}
						className="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600 w-full sm:w-auto"
					>
						Get All Users
					</button>
				</div>
			</div>

			{modalVisible && (
				<div className="fixed inset-0 bg-gray-800 bg-opacity-50 flex items-center justify-center z-50">
					<div className="bg-white p-6 rounded-lg shadow-lg w-80">
						<h2 className="text-lg font-bold mb-4">Update User</h2>
						<input
							type="text"
							value={updateName}
							onChange={(e) => setUpdateName(e.target.value)}
							className="px-4 py-2 border border-gray-300 rounded w-full mb-4"
						/>
						<div className="flex justify-end gap-2">
							<button
								onClick={updateUser}
								className="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600"
							>
								Save
							</button>
							<button
								onClick={closeUpdateModal}
								className="px-4 py-2 bg-gray-500 text-white rounded hover:bg-gray-600"
							>
								Cancel
							</button>
						</div>
					</div>
				</div>
			)}
		</div>
	)
}

export default UserList
