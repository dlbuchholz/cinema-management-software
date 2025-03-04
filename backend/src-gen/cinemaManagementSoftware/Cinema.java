/**
 */
package cinemaManagementSoftware;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cinema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cinemaManagementSoftware.Cinema#getId <em>Id</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Cinema#getName <em>Name</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Cinema#getLocation <em>Location</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Cinema#getOwner <em>Owner</em>}</li>
 *   <li>{@link cinemaManagementSoftware.Cinema#getHall <em>Hall</em>}</li>
 * </ul>
 *
 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getCinema()
 * @model
 * @generated
 */
public interface Cinema extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(long)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getCinema_Id()
	 * @model
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Cinema#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(long value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getCinema_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Cinema#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getCinema_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Cinema#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(CinemaOwner)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getCinema_Owner()
	 * @model required="true"
	 * @generated
	 */
	CinemaOwner getOwner();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.Cinema#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(CinemaOwner value);

	/**
	 * Returns the value of the '<em><b>Hall</b></em>' reference list.
	 * The list contents are of type {@link cinemaManagementSoftware.CinemaHall}.
	 * It is bidirectional and its opposite is '{@link cinemaManagementSoftware.CinemaHall#getCinema <em>Cinema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hall</em>' reference list.
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getCinema_Hall()
	 * @see cinemaManagementSoftware.CinemaHall#getCinema
	 * @model opposite="cinema" required="true"
	 * @generated
	 */
	EList<CinemaHall> getHall();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void totalIncome();

} // Cinema
