#!/usr/bin/env python3
"""Lista de compute aplazables (<datos>/computes_aplazables) a partir de la auditoría de shaders.

Son las simulaciones de Niagara de Unreal Engine 5: corren en cada frame, así que no hacer su dispatch unos frames
mientras se traducen en segundo plano solo retrasa el efecto (program.cpp, ensure_translated). Un compute que corre una
sola vez no puede ir aquí.

Uso: tools/aplazables.py [work/shader_audit/programas.tsv] > work/computes_aplazables
     adb push work/computes_aplazables <data>/computes_aplazables
"""
import csv
import sys

NOMBRES = ('NiagaraEmitterInstanceShader.usf:SimulateMainComputeCS', 'StatelessMain')

tsv = sys.argv[1] if len(sys.argv) > 1 else 'work/shader_audit/programas.tsv'
vistos = set()
with open(tsv, newline='') as f:
    for fila in csv.DictReader(f, delimiter='\t'):
        if fila['etapa'] == 'compute' and '/Niagara/' in fila['shader'] and fila['shader'].endswith(NOMBRES):
            vistos.add(fila['huella'])
for h in sorted(vistos):
    print(h)
print(f'{len(vistos)} huellas', file=sys.stderr)
