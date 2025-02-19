/**
 */
package cinemaManagementSoftware.impl;

import cinemaManagementSoftware.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CinemaManagementSoftwareFactoryImpl extends EFactoryImpl
		implements CinemaManagementSoftwareFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CinemaManagementSoftwareFactory init() {
		try {
			CinemaManagementSoftwareFactory theCinemaManagementSoftwareFactory = (CinemaManagementSoftwareFactory) EPackage.Registry.INSTANCE
					.getEFactory(CinemaManagementSoftwarePackage.eNS_URI);
			if (theCinemaManagementSoftwareFactory != null) {
				return theCinemaManagementSoftwareFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CinemaManagementSoftwareFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CinemaManagementSoftwareFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case CinemaManagementSoftwarePackage.CINEMA:
			return createCinema();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Cinema createCinema() {
		CinemaImpl cinema = new CinemaImpl();
		return cinema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CinemaManagementSoftwarePackage getCinemaManagementSoftwarePackage() {
		return (CinemaManagementSoftwarePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CinemaManagementSoftwarePackage getPackage() {
		return CinemaManagementSoftwarePackage.eINSTANCE;
	}

} //CinemaManagementSoftwareFactoryImpl
