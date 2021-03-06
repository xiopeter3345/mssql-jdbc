//---------------------------------------------------------------------------------------------------------------------------------
// File: SQLServerColumnEncryptionKeyStoreProvider.java
//
//
// Microsoft JDBC Driver for SQL Server
// Copyright(c) Microsoft Corporation
// All rights reserved.
// MIT License
// Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files(the "Software"), 
//  to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
//  and / or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions :
// The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
// THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
//  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
//  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS 
//  IN THE SOFTWARE.
//---------------------------------------------------------------------------------------------------------------------------------
 
 
package com.microsoft.sqlserver.jdbc;

/**
 * 
 * Extend this class to implement a custom key store provider.
 *
 */
public abstract class SQLServerColumnEncryptionKeyStoreProvider {
	
	/**
	 * Sets the name of this key store provider.
	 * @param name value to be set for the key store provider.
	 */
	public abstract void setName(String name);
	
	/**
	 * Retrieves the name of this key store provider.
	 * @return the name of this key store provider.
	 */
	public abstract String getName();
	
	/**
	 * Base class method for decrypting the specified encrypted value of a column encryption key. 
	 * The encrypted value is expected to be encrypted using the column master key with the specified key path and using the specified algorithm.
	 * @param masterKeyPath The column master key path.
	 * @param encryptionAlgorithm the specific encryption algorithm.
	 * @param encryptedColumnEncryptionKey the encrypted column encryption key
	 * @return the decrypted value of column encryption key.
	 * @throws SQLServerException when an error occurs while decrypting the CEK
	 */
	public abstract byte [] decryptColumnEncryptionKey(String masterKeyPath,String encryptionAlgorithm,byte [] encryptedColumnEncryptionKey) throws SQLServerException;
	
	/**
	 * Base class method for encrypting a column encryption key using the column master key with the specified key path and using the specified algorithm.
	 * @param masterKeyPath The column master key path.
	 * @param encryptionAlgorithm the specific encryption algorithm.
	 * @param columnEncryptionKey column encryption key to be encrypted.
	 * @return the encrypted column encryption key.
	 * @throws SQLServerException when an error occurs while encrypting the CEK
	 */
	public abstract byte [] encryptColumnEncryptionKey(String masterKeyPath,String encryptionAlgorithm,byte [] columnEncryptionKey) throws SQLServerException;

}
