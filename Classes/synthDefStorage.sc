// simply stores synthDefs in an accessible dict
SynthDefStorage {

	classvar <>synthDefDict ;

	*initClass {

		Class.initClassTree(Dictionary) ;
		synthDefDict = Dictionary.new ;

		Class.initClassTree(SynthDef) ;
		SynthDef.addDependant(this) ; // using SC enhancement #5657
	}

	*update { arg obvious, iKnow, aSynthDef ;

		synthDefDict.add(aSynthDef.name -> [
			aSynthDef,
			aSynthDef.func.asCompileString
		])
	}
}
