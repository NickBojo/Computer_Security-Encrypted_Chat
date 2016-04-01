# Computer Security: Encrypted_Chat

This program provides an encrypted chat interface, whose purpose is to walk through and display the steps involved in mutual authentication and encryption. If the shared secret value is the same on both instances of the chat (server and client), the interface will display the steps in the Diffie-Hellman key exchange, mutual authentication, and the Triple DES chat encryption and decryption.

For testing, one can open two instances of VPNgui.jar. Set one instance to Client and the other to Server. The port and IP default to 8000 and localhost. The "Shared Secret Value" field needs to contain the same stream for authentication to occur.
