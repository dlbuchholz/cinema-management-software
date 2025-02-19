/**
 */
package cinemaManagementSoftware;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see cinemaManagementSoftware.CinemaManagementSoftwareFactory
 * @model kind="package"
 * @generated
 */
public interface CinemaManagementSoftwarePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cinemaManagementSoftware";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/cinemaManagementSoftware";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cinemaManagementSoftware";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CinemaManagementSoftwarePackage eINSTANCE = cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl
			.init();

	/**
	 * The meta object id for the '{@link cinemaManagementSoftware.impl.CinemaImpl <em>Cinema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cinemaManagementSoftware.impl.CinemaImpl
	 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getCinema()
	 * @generated
	 */
	int CINEMA = 0;

	/**
	 * The number of structural features of the '<em>Cinema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Cinema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CINEMA_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link cinemaManagementSoftware.Cinema <em>Cinema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cinema</em>'.
	 * @see cinemaManagementSoftware.Cinema
	 * @generated
	 */
	EClass getCinema();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CinemaManagementSoftwareFactory getCinemaManagementSoftwareFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link cinemaManagementSoftware.impl.CinemaImpl <em>Cinema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cinemaManagementSoftware.impl.CinemaImpl
		 * @see cinemaManagementSoftware.impl.CinemaManagementSoftwarePackageImpl#getCinema()
		 * @generated
		 */
		EClass CINEMA = eINSTANCE.getCinema();

	}

} //CinemaManagementSoftwarePackage
