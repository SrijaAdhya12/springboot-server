import React, { useState, useEffect } from 'react'
import axios from 'axios'

const UserList = () => {
	// const [users, setUsers] = useState([])

	// useEffect(() => {
	// 	const fetchUsers = async () => {
	// 		try {
	// 			const response = await axios.get(`${import.meta.env.VITE_API}/users`) 
	// 			setUsers(response.data)
	// 		} catch (error) {
	// 			console.error('Error fetching users:', error)
	// 		}
	// 	}

	// 	fetchUsers()
	// }, [])

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
				{/* <tbody>
					{users.map((user) => (
						<tr key={user.id}>
							<td className="py-2 px-4 border-b">{user.id}</td>
							<td className="py-2 px-4 border-b">{user.name}</td>
						</tr>
					))}
				</tbody> */}
			</table>
		</div>
	)
}

export default UserList
