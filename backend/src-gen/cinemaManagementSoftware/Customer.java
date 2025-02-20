/**
 */
package cinemaManagementSoftware;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cinemaManagementSoftware.Customer#getTicket <em>Ticket</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Customer#getEmail <em>Email</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Customer#getTelephone <em>Telephone</em>}</li>
 * </ul>
 *
 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getCustomer()
 * @model
 * @generated
 */
public interface Customer extends Person {
	/**
	 * Returns the value of the '<em><b>Ticket</b></em>' reference list.
	 * The list contents are of type {@link cinemaManagementSoftware.Ticket}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ticket</em>' reference list.
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getCustomer_Ticket()
	 * @model required="true"
	 * @generated
	 */
	EList<Ticket> getTicket();

	/**
	 * Returns the value of the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Email</em>' attribute.
	 * @see #setEmail(String)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getCustomer_Email()
	 * @model
	 * @generated
	 */
	String getEmail();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Customer#getEmail <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email</em>' attribute.
	 * @see #getEmail()
	 * @generated
	 */
	void setEmail(String value);

	/**
	 * Returns the value of the '<em><b>Telephone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Telephone</em>' attribute.
	 * @see #setTelephone(String)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getCustomer_Telephone()
	 * @model
	 * @generated
	 */
	String getTelephone();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Customer#getTelephone <em>Telephone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Telephone</em>' attribute.
	 * @see #getTelephone()
	 * @generated
	 */
	void setTelephone(String value);

} // Customer
