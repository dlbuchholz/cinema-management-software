/**
 */
package cinemaManagementSoftware;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cinema Hall</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cinemaManagementSoftware.CinemaHall#getRow <em>Row</em>}</li>
 *   <li>{@link cinemaManagementSoftware.CinemaHall#getId <em>Id</em>}</li>
 *   <li>{@link cinemaManagementSoftware.CinemaHall#getName <em>Name</em>}</li>
 *   <li>{@link cinemaManagementSoftware.CinemaHall#getCinema <em>Cinema</em>}</li>
 * </ul>
 *
 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getCinemaHall()
 * @model
 * @generated
 */
public interface CinemaHall extends EObject {
	/**
	 * Returns the value of the '<em><b>Row</b></em>' reference list.
	 * The list contents are of type {@link cinemaManagementSoftware.SeatingRow}.
	 * It is bidirectional and its opposite is '{@link cinemaManagementSoftware.SeatingRow#getCinemahall <em>Cinemahall</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row</em>' reference list.
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getCinemaHall_Row()
	 * @see cinemaManagementSoftware.SeatingRow#getCinemahall
	 * @model opposite="cinemahall" required="true"
	 * @generated
	 */
	EList<SeatingRow> getRow();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getCinemaHall_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.CinemaHall#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getCinemaHall_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.CinemaHall#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Cinema</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link cinemaManagementSoftware.Cinema#getHall <em>Hall</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cinema</em>' reference.
	 * @see #setCinema(Cinema)
	 * @see cinemaManagementSoftware.CinemaManagementSoftwarePackage#getCinemaHall_Cinema()
	 * @see cinemaManagementSoftware.Cinema#getHall
	 * @model opposite="hall" required="true"
	 * @generated
	 */
	Cinema getCinema();

	/**
	 * Sets the value of the '{@link cinemaManagementSoftware.CinemaHall#getCinema <em>Cinema</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cinema</em>' reference.
	 * @see #getCinema()
	 * @generated
	 */
	void setCinema(Cinema value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	void isConfigComplete();

} // CinemaHall
